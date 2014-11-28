package cn.jc.ee;

import java.util.Date;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import cn.jc.ee.model.GoldJsb;
/**
 * 中间处理程序
 * @author jince
 *
 */
@Component("myprocessor")
public class MyItemProcessor  implements ItemProcessor<GoldJsb, GoldJsb>{

	@Override
	public GoldJsb process(GoldJsb item) throws Exception {
		Date d = new Date();
		item.setId(d.getTime()/1000/60*60);
		item.setCreated(d);
		return item;
	}

}
