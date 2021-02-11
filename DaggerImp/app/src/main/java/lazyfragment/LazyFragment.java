package lazyfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LazyFragment extends Fragment {

    //MainActivity--ViewPager-->LazyFragmentA,LazyFragmentB,LazyFragmentC,LazyFragmentD(DetailActivity),
    //scenario1: Switch between B and D, the other fragment did't load and stop load data
    //scenario2:LazyFragmentD->DetailActivity->go back, LazyFragmentD should load data

    boolean isCreateView=false;
    boolean isCurrentViewVisable =false;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
        //set view update by setUserVisibleHint to implement lazy load
//        isCreateView=true;
//        if(isCreateView){
//            setUserVisibleHint(true);
//        }


    }

    //set current fragment is visible or not,it is using in ViewPager lazy loading mode
    //Be careful, when we call this method, we should check view isCreateView true or not
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(!isCurrentViewVisable && isVisibleToUser){// before is "!isCurrentViewVisisable" not visible ,but now is "isVisibleToUser" visible
            loadData(isVisibleToUser);
        }else if(isCurrentViewVisable &&!isVisibleToUser){//scenario1: 防止 loadData（false） call many times in background
            loadData(isVisibleToUser);
        }
    }

    private void loadData(boolean b) {
        isCurrentViewVisable =b;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(getUserVisibleHint() && !isCurrentViewVisable){// scenario 2
            loadData(true);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if(getUserVisibleHint() && isCurrentViewVisable){//scenario 2
            loadData(false);
        }
    }
}
