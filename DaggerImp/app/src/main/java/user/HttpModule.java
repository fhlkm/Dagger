package user;

import dagger.Module;
import dagger.Provides;

@Module
public class HttpModule {

    @Provides
    public StringBuilder provideOKHttp(){

        return new StringBuilder("provideOKHttp");
    }
}
