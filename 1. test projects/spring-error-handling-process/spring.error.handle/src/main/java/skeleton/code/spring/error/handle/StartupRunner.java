package skeleton.code.spring.error.handle;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import skeleton.code.spring.error.handle.bean.Parent;

@Component
@RequiredArgsConstructor
public class StartupRunner implements ApplicationListener<ContextRefreshedEvent> {

    private final Parent parent;

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        parent.print();
    }
}
