package presenter;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {


    @Provides
    public Presenter providerPresenter(){
        return new Presenter();
    }
}
