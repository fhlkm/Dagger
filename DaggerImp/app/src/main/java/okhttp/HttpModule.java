package okhttp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import scope.AppScope;
import scope.UserScope;

@AppScope
@Module
public class HttpModule {

    @AppScope
    @Provides
    public HttpObject provideHttpObject(){
        return  new HttpObject();
    }
}
