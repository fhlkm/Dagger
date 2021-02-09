package okhttp;

import com.example.daggerimp.MainActivity;
import com.example.daggerimp.SecondActivity;

import dagger.Component;
import presenter.PresenterComponent;
import scope.AppScope;
import user.UserComponent;


@AppScope
@Component(modules ={HttpModule.class,DataBaseModule.class},dependencies = {PresenterComponent.class,UserComponent.class})
public interface MyComponent {


    void inject(MainActivity mainActivity);

    void inject(SecondActivity secondActivity);

}
