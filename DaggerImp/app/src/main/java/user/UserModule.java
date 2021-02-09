package user;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import scope.Manager;
import scope.UserScope;

@Module(includes = {HttpModule.class})
public class UserModule {
    Context context;
    public UserModule(Context context){
        this.context = context;
    }


    @Provides
    public int provideOKHttp(StringBuilder okhttp){
        return okhttp.toString().length();
    }
    @Provides
    public String getUserName(){

        return "User";
    }
}
