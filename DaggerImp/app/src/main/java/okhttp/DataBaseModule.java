package okhttp;

import dagger.Module;
import dagger.Provides;

@Module
public class DataBaseModule {

    @Provides
    public DataBaseObject provideDatabaseObject(){
        return new DataBaseObject();
    }
}
