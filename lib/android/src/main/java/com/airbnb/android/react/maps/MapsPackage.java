package com.airbnb.android.react.maps;

import android.app.Activity;

import com.airbnb.android.react.maps.amap.AMapCalloutManager;
import com.airbnb.android.react.maps.amap.AMapCircleManager;
import com.airbnb.android.react.maps.amap.AMapMarkerManager;
import com.airbnb.android.react.maps.amap.AMapPolygonManager;
import com.airbnb.android.react.maps.amap.AMapPolylineManager;
import com.airbnb.android.react.maps.amap.AMapViewManager;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MapsPackage implements ReactPackage {
    public MapsPackage(Activity activity) {
    } // backwards compatibility

    public MapsPackage() {
    }

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        return Arrays.<NativeModule>asList(new AirMapModule(reactContext));
    }

    @Override
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        AirMapCalloutManager calloutManager = new AirMapCalloutManager();
        AirMapMarkerManager annotationManager = new AirMapMarkerManager();
        AirMapPolylineManager polylineManager = new AirMapPolylineManager(reactContext);
        AirMapPolygonManager polygonManager = new AirMapPolygonManager(reactContext);
        AirMapCircleManager circleManager = new AirMapCircleManager(reactContext);
        AirMapManager mapManager = new AirMapManager(reactContext);
        AirMapLiteManager mapLiteManager = new AirMapLiteManager(reactContext);
        AirMapUrlTileManager tileManager = new AirMapUrlTileManager(reactContext);

        AMapCalloutManager amapCalloutManager = new AMapCalloutManager();
        AMapMarkerManager amapAnnotationManager = new AMapMarkerManager();
        AMapPolylineManager amapPolylineManager = new AMapPolylineManager(reactContext);
        AMapPolygonManager amapPolygonManager = new AMapPolygonManager(reactContext);
        AMapCircleManager amapCircleManager = new AMapCircleManager(reactContext);

        AMapViewManager amapMapManager = new AMapViewManager(
                amapAnnotationManager,
                amapPolylineManager,
                amapPolygonManager,
                amapCircleManager
        );

        return Arrays.<ViewManager>asList(
                calloutManager,
                annotationManager,
                polylineManager,
                polygonManager,
                circleManager,
                mapManager,
                mapLiteManager,
                tileManager,

                //amap

                amapCalloutManager,
                amapAnnotationManager,
                amapPolylineManager,
                amapPolygonManager,
                amapCircleManager,
                amapMapManager

                );
    }
}
