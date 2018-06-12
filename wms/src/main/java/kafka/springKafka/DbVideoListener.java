package kafka.springKafka;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * 监听器，启动更新视频
 *
 * @author: qidima
 * @date: 2018/6/12
 * Time: 16:43
 */

public class DbVideoListener implements ApplicationListener<ContextRefreshedEvent> {
    static ApplicationContext applicationContext;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (contextRefreshedEvent.getApplicationContext().getParent() == null) {
            DbVideoConsumerHandler handler = (DbVideoConsumerHandler) contextRefreshedEvent.getApplicationContext().getBean("dbVideoConsumerHandler");
            setApplicationContext(contextRefreshedEvent.getApplicationContext());
            handler.init();
        }
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}
