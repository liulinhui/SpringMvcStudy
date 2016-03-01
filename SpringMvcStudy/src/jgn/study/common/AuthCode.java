package jgn.study.common;
import org.patchca.color.ColorFactory;
import org.patchca.filter.predefined.*;
import org.patchca.service.ConfigurableCaptchaService;
import org.patchca.utils.encoder.EncoderHelper;
import org.patchca.word.RandomWordFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;
import java.util.Random;
/**
 * patchca生成验证码
 *
 * @author jgn 16-1-7 下午6:55
 */
@Controller
public class AuthCode {
	
	private static ConfigurableCaptchaService jgnConfig = new ConfigurableCaptchaService();
    private static Random random = new Random();
    static {
    	jgnConfig.setColorFactory(new ColorFactory() {
            @Override
            public Color getColor(int x) {
                int[] c = new int[3];
                int i = random.nextInt(c.length);
                for (int fi = 0; fi < c.length; fi++) {
                    if (fi == i) {
                        c[fi] = random.nextInt(71);
                    } else {
                        c[fi] = random.nextInt(256);
                    }
                }
                return new Color(c[0], c[1], c[2]);
            }
        });
        RandomWordFactory wf = new RandomWordFactory();
        wf.setCharacters("23456789abcdefghigkmnpqrstuvwxyzABCDEFGHIGKLMNPQRSTUVWXYZ");
        wf.setMaxLength(5);
        wf.setMinLength(4);
        jgnConfig.setWordFactory(wf);
        jgnConfig.setHeight(45);
        jgnConfig.setWidth(160);
    }
    @RequestMapping("/jgnCode")
    public void crimg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        switch (random.nextInt(5)) {
            case 0:
            	jgnConfig.setFilterFactory(new CurvesRippleFilterFactory(jgnConfig.getColorFactory()));
                break;
            case 1:
            	jgnConfig.setFilterFactory(new MarbleRippleFilterFactory());
                break;
            case 2:
            	jgnConfig.setFilterFactory(new DoubleRippleFilterFactory());
                break;
            case 3:
            	jgnConfig.setFilterFactory(new WobbleRippleFilterFactory());
                break;
            case 4:
            	jgnConfig.setFilterFactory(new DiffuseRippleFilterFactory());
                break;
        }
        HttpSession session = request.getSession(false);
        if (session == null) {
            session = request.getSession();
        }
        setResponseHeaders(response);
        String jgnCode = EncoderHelper.getChallangeAndWriteImage(jgnConfig, "png", response.getOutputStream());
        session.setAttribute("jgnCode", jgnCode);
    }
    protected void setResponseHeaders(HttpServletResponse response) {
        response.setContentType("image/png");
        response.setHeader("Cache-Control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        long time = System.currentTimeMillis();
        response.setDateHeader("Last-Modified", time);
        response.setDateHeader("Date", time);
        response.setDateHeader("Expires", time);
    }

}
