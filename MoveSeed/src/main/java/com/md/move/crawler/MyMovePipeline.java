package com.md.move.crawler;

import com.md.move.dao.MoveDao;
import com.md.move.entity.Move;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;
import java.util.Map;

/**
 * @类名: ${CLASS_NAME}
 * @包名: com.md.move.crawler
 * @描述: ${TODO}(用一句话描述该文件做什么)
 * @日期: 2018/2/2 10:10
 * @版本: V1.0
 * @创建人：马东
 * @修改人：马东
 */
public class MyMovePipeline implements Pipeline {
    private MoveDao moveDao;
    public MyMovePipeline (MoveDao moveDao){
        this.moveDao = moveDao;
    }

    @Override
    public void process(ResultItems resultItems, Task task) {
        List<Move> moves = resultItems.get("moves");
        moveDao.insertMoves(moves);
        /*for(Move move:moves){
            moveDao.insertMove(move);
        }*/
    }
}
