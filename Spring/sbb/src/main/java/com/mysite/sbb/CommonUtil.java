
package com.mysite.sbb;

import org.springframework.stereotype.Component;

import org.commonmark.renderer.html.HtmlRenderer;
import org.commonmark.parser.Parser;
import org.commonmark.node.Node;

@Component
// @Component : bean 자바 객체로 등록
// markdown 메서드 생성 : 마크다운 텍스트 -> HTML로 변환
public class CommonUtil {
    public String markdown(String markdown){
        Parser parser = Parser.builder().build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(document);
    }
}
