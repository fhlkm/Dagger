package user;

import android.content.Context;

import com.example.daggerimp.MainActivity;

import dagger.Component;
import dagger.Provides;
import presenter.Presenter;
import presenter.PresenterModule;
import scope.Manager;
import scope.UserScope;


@Component(modules  ={UserModule.class})
public interface UserComponent {

   String providerUser();
   int providerOKHttp();
}
