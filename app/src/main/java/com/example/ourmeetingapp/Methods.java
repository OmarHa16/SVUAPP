package com.example.ourmeetingapp;

public class Methods {

    public void setColorTheme(){

        switch (Constant.color){
            case 0xffF44336:
                Constant.theme = R.style.AppThem_red;
                break;
            case 0xffE91E63:
                Constant.theme = R.style.AppThem_pink;
                break;
            case 0xff9C27B0:
                Constant.theme = R.style.AppThem_darpink;
                break;
            case 0xff673AB7:
                Constant.theme = R.style.AppThem_violet;
                break;
            case 0xff3F51B5:
                Constant.theme = R.style.AppThem_blue;
                break;

            default:
                Constant.theme = R.style.Theme_OurMeetingApp;
                break;
        }
    }
}

