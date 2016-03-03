package jgn.study.directive;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

import java.io.IOException;
import java.util.Map;

/**
 * User: jgn
 * Date: 16-1-7
 * Time: 下午5:45
 */
////////////////////////////////////
//////////////////////////////////
////////////////////////////////////////
////////////////////////////////////////////////////
public class PageDirective implements TemplateDirectiveModel {

    public PageDirective() {

    }

    @Override
    public void execute(Environment environment, Map map,
                        TemplateModel[] templateModels,
                        TemplateDirectiveBody templateDirectiveBody)
            throws TemplateException, IOException {
        StringBuilder pageDiv = new StringBuilder();
        Object totalNumObj = map.get("totalNum") == null ? 0 : map.get("totalNum");    //总条数
        Object currentNumObj = map.get("currentPageNum") == null ? 0 : map.get("currentPageNum");    //当前第几页
        Object currentPageNumObj = map.get("totalPageNum") == null ? 0 : map.get("totalPageNum");//总页数
        pageDiv.append("<div class='page-bar'>");
        pageDiv.append("<span>共</span>");
        pageDiv.append("<span class='bluefont'>");
        pageDiv.append(totalNumObj.toString());
        pageDiv.append("</span>");
        pageDiv.append("<span>页&nbsp;&nbsp;当前第</span>");
        pageDiv.append("<span class='bluefont'>");
        pageDiv.append(currentNumObj.toString());
        pageDiv.append("</span><span>页，共</span><span class='bluefont'>");
        pageDiv.append(currentPageNumObj);
        pageDiv.append("</span>页<button id='upper'>上一页</button>  <button id='next'>下一页</button></div>");
        environment.getOut().write(pageDiv.toString());

    }

}