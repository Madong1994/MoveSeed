package com.md.move.dao.provider;

import com.md.move.entity.Move;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 * @类名: ${CLASS_NAME}
 * @包名: com.md.move.dao.provider
 * @描述: ${TODO}(用一句话描述该文件做什么)
 * @日期: 2018/2/2 11:17
 * @版本: V1.0
 * @创建人：马东
 * @修改人：马东
 */
public class provider {
    //    @Insert("INSERT INTO move (move_type,move_name,resource,size,gain_date, type) values (#{move_type},#{move_name},#{resource},#{size},#{gain_date},#{type})")
    public String insertAllMove(Map map) {
        List<Move> typeCounts = (List<Move>) map.get("list");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO move");
        sb.append("(move_type,move_name,resource,size,gain_date,type) ");
        sb.append("VALUES ");
        MessageFormat mf = new MessageFormat("(#'{'list[{0}].move_type}, #'{'list[{0}].move_name},#'{'list[{0}].resource},#'{'list[{0}].size},#'{'list[{0}].gain_date},#'{'list[{0}].type})");
        for (int i = 0; i < typeCounts.size(); i++) {
            sb.append(mf.format(new Object[]{i}));
            if (i < typeCounts.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
