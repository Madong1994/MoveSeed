package com.md.move.crawler;

import com.md.move.dao.MoveDao;
import com.md.move.entity.Move;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 马东 on 2018/1/6.
 *
 * @Author:madong
 * @Description:
 * @Date:Create in 14:13 2018/1/6
 * 关关雎鸠，在河之洲，
 * 窈窕淑女，君子好逑。
 */
public class MyMoveProcesser implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    public static void main(String[] args) {

        System.out.println("开始爬取...");
        long startTime = System.currentTimeMillis();
        Spider.create(new MyMoveProcesser())
                .addUrl("http://www.55xia.com/?page=5") .thread(5).run();
        long endTime = System.currentTimeMillis();
        System.out.println("爬取结束...共耗时："+(endTime-startTime)/1000+"秒");
    }

    /**
     * 开始爬取数据
     */
    public static void startGetPage(MoveDao moveDao){
        System.out.println("开始爬取...");
        long startTime = System.currentTimeMillis();
        Spider.create(new MyMoveProcesser())
                .addUrl("http://www.55xia.com/?page=5") .addPipeline(new MyMovePipeline(moveDao)).thread(5).run();
        long endTime = System.currentTimeMillis();
        System.out.println("爬取结束...共耗时："+(endTime-startTime)/1000+"秒");
    }
    @Override
    public void process(Page page) {
        if(page.getUrl().regex("http://www\\.55xia\\.com/.*").match()){
            List<Move> moves = new ArrayList<>();
//            List<String> trs = page.getHtml().xpath("/html/body/div/table/tbody/tr").all();
            List<String> trs = page.getHtml().xpath("/html/body/div/table/tbody/tr").all();
//            List<String> trs = page.getHtml().css(".table > tbody:nth-child(2)").all();
            for(String tr: trs){
//                System.out.println(tr);
                tr = tr.replaceAll( "tr", "ul" );

                tr = tr.replaceAll( "td", "li" );

                Html html = new Html( tr );
                String typeName = html.xpath( "//ul/li[1]/text()" ).toString();
                String moveName = html.xpath( "//ul/li[2]/a/text()" ).toString();
                String resource = html.xpath( "//ul/li[2]/a/@href" ).toString();
                String size = html.xpath( "//ul/li[4]/text()" ).toString();
                String date = html.xpath( "//ul/li[5]/text()" ).toString();
                Move move = new Move();
                move.setMove_name(moveName);
                move.setGain_date(date);
                move.setResource(resource);
                move.setSize(size);
                move.setMove_type(typeName);
                if("日韩电影".equals(typeName)){
                    move.setType(2);
                }
                if("欧美电影".equals(typeName)){
                    move.setType(1);
                }
                if("国产电影".equals(typeName)){
                    move.setType(3);
                }
                if("动画电影".equals(typeName)){
                    move.setType(4);
                }
                if(null == typeName){
                    move.setType(0);
                }
                moves.add(move);
//                System.out.println(typeName + "------"+moveName+"----&"+resource+"&---"+size+"---"+date);
            }
            page.putField("moves",moves);
            //.table > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(1)
        }
    }

    @Override
    public Site getSite() {
        return site;
    }
}
