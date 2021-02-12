package com.yuhdeveloper.dizibulmaca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 19.03.2018.
 */

public class DataPool {
    ArrayList<Integer> drawables;
    int size = 0;

    public ArrayList<Integer> getDrawable(int value) {

        drawables = new ArrayList<>();
        if (value == 0) {
            return getCukur();
        }
        else if (value == 1)  {
            return getUfakTefekCinayetler();
        }
        else if (value == 2)  {
            return getEskiya();
        }
        else if (value == 3)  {
            return getDirilis();
        }
        else if (value == 4)  {
            return getCarpisma();
        }


        return null;

    }
    public int getPlaceHolder(int value){
        if(value == 0){
            return R.drawable.dizi_cukur;
        }
        else if(value == 1){
            return R.drawable.dizi_ufaktefek;
        }
        else if(value == 2){
            return R.drawable.dizi_eskiya_dunyaya;
        }
        else if(value == 3){
            return R.drawable.dizi_dirilis;
        }
        else if(value == 4){
            return R.drawable.dizi_carpisma;
        }
        else{
            return 0;
        }
    }

    public List<String> getLstName() {
        List<String> lstName = new ArrayList<>();

        lstName.add("ÇUKUR");
        lstName.add("UFAK TEFEK CİNAYETLER");
        lstName.add("EŞKİYA DÜNYAYA HÜKÜMDAR OLMAZ");
        lstName.add("DİRİLİŞ ERTUĞRUL");
        lstName.add("ÇARPIŞMA");

        return lstName;
    }

    public List<Integer> getLstImage() {
        List<Integer> lstImage = new ArrayList<>();

        lstImage.add(R.drawable.dizi_cukur);
        lstImage.add(R.drawable.dizi_ufaktefek);
        lstImage.add(R.drawable.dizi_eskiya_dunyaya);
        lstImage.add(R.drawable.dizi_dirilis);
        lstImage.add(R.drawable.dizi_carpisma);
        return lstImage;
    }

    ArrayList<Integer> getCukur() {

        drawables = new ArrayList<Integer>();
        drawables.add(R.drawable.cukur_aras_bulut);
        drawables.add(R.drawable.cukur_aytac_usun);
        drawables.add(R.drawable.cukur_burak_sergen);
        drawables.add(R.drawable.cukur_cetin_sarikartal);

        drawables.add(R.drawable.cukur_dilen_cicek_deniz);
        drawables.add(R.drawable.cukur_elif_dogan);
        drawables.add(R.drawable.cukur_ercan_kesal);
        drawables.add(R.drawable.cukur_ercan_kolcak);

        drawables.add(R.drawable.cukur_kadir_cermik);
        drawables.add(R.drawable.cukur_kemal_yildiran);
//        drawables.add(R.drawable.cukur_kubilay_aka);
//        drawables.add(R.drawable.cukur_nebil_saygin);

        size = drawables.size();
        for(int i = 0;size>i;i++){
            drawables.add(drawables.get(i));
        }

        return drawables;
    }

    ArrayList<Integer> getDirilis() {

        drawables = new ArrayList<Integer>();
        drawables.add(R.drawable.dirilis_beybolat);
        drawables.add(R.drawable.dirilis_dragos);
        drawables.add(R.drawable.dirilis_ertugrul);
        drawables.add(R.drawable.dirilis_gundogdu);

        drawables.add(R.drawable.dirilis_ilbilge);
        drawables.add(R.drawable.dirilis_osman);
        drawables.add(R.drawable.dirilis_selcan);
        drawables.add(R.drawable.dirilis_sirma);

        drawables.add(R.drawable.dirilis_suleyman);
        drawables.add(R.drawable.dirilis_irene);
//        drawables.add(R.drawable.cukur_kubilay_aka);
//        drawables.add(R.drawable.cukur_nebil_saygin);

        size = drawables.size();
        for(int i = 0;size>i;i++){
            drawables.add(drawables.get(i));
        }

        return drawables;
    }



    ArrayList<Integer> getCarpisma() {

        drawables = new ArrayList<Integer>();
        drawables.add(R.drawable.carpisma_asli);
        drawables.add(R.drawable.carpisma_belme);
        drawables.add(R.drawable.carpisma_cemre);
        drawables.add(R.drawable.carpisma_demir);

        drawables.add(R.drawable.carpisma_galip);
        drawables.add(R.drawable.carpisma_haydar);
        drawables.add(R.drawable.carpisma_kerem);
        drawables.add(R.drawable.carpisma_mahir);

        drawables.add(R.drawable.carpisma_selim);
        drawables.add(R.drawable.carpisma_zeynep);
//        drawables.add(R.drawable.cukur_kubilay_aka);
//        drawables.add(R.drawable.cukur_nebil_saygin);

        size = drawables.size();
        for(int i = 0;size>i;i++){
            drawables.add(drawables.get(i));
        }

        return drawables;
    }

    ArrayList<Integer> getEskiya() {

        drawables = new ArrayList<Integer>();
        drawables.add(R.drawable.eskiya_alpaslan);
        drawables.add(R.drawable.eskiya_ceylan);
        drawables.add(R.drawable.eskiya_ekrem);
        drawables.add(R.drawable.eskiya_hizir2);

        drawables.add(R.drawable.eskiya_hizir_cakirbeyli);
        drawables.add(R.drawable.eskiya_ilyas);
        drawables.add(R.drawable.eskiya_irem);
        drawables.add(R.drawable.eskiya_sabina);

        drawables.add(R.drawable.eskiya_sahin);
        drawables.add(R.drawable.eskiya_unal_kaplan);
//        drawables.add(R.drawable.eskiya_yasar_kimsesiz);
//        drawables.add(R.drawable.eskiya_meryem_cakirbeyli);

        size = drawables.size();
        for(int i = 0;size>i;i++){
            drawables.add(drawables.get(i));
        }

        return drawables;

    }
    ArrayList<Integer> getUfakTefekCinayetler() {

        drawables = new ArrayList<Integer>();
        drawables.add(R.drawable.ufak_arzu);
        drawables.add(R.drawable.ufak_aslihan);
        drawables.add(R.drawable.ufak_edip);
        drawables.add(R.drawable.ufak_erhan);

        drawables.add(R.drawable.ufak_gokce_bahadir);
        drawables.add(R.drawable.ufak_mehmet);
        drawables.add(R.drawable.ufak_merve);
        drawables.add(  R.drawable.ufak_pelin);

        drawables.add(R.drawable.ufak_taylan);
        drawables.add(R.drawable.ufak_sema);
//        drawables.add(R.drawable.ufak_avukat);
//        drawables.add(R.drawable.ufak_mervegenc);

        size = drawables.size();
        for(int i = 0;size>i;i++){
            drawables.add(drawables.get(i));
        }

        return drawables;

    }
}
