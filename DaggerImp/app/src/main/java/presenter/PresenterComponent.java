package presenter;

import dagger.Component;
import scope.UserScope;



@Component(modules  ={PresenterModule.class})
public interface PresenterComponent {

//find from PresenterModule
    Presenter providerPresent();

}
