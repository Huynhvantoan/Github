-keepattributes SourceFile,LineNumberTable,Exceptions
-keepnames class * extends java.lang.Throwable


-keepclassmembers class fqcn.of.javascript.interface.for.webview {
   public *;
}

# ----------------------------------------
# Retrolambda
# ----------------------------------------
-dontwarn java.lang.invoke.*


# ----------------------------------------
# Parceler rules
# ----------------------------------------
-keep class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}
-keep class org.parceler.Parceler$$Parcels


# ----------------------------------------
# ButterKnife 8
# ----------------------------------------
-keep class butterknife.** { *; }
-dontwarn butterknife.internal.**
-keep class **$$ViewBinder { *; }
-keep public class * implements butterknife.Unbinder { public <init>(...); }
-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}
-keepclasseswithmembernames class * {
    @butterknife.* <methods>;
}

# ----------------------------------------
# Realm
# ----------------------------------------
-keep class com.kct.box.mvp.model.** { *; }
-keep class io.realm.annotations.RealmModule
-keep @io.realm.annotations.RealmModule class *
-keep class io.realm.internal.Keep
-keep @io.realm.internal.Keep class * { *; }
-dontwarn javax.**
-dontwarn io.realm.**


# ----------------------------------------
# Glide
# ----------------------------------------
-dontwarn jp.co.cyberagent.android.gpuimage.**
-keep class com.kct.box.data.glidemodule.OkHttpGlideModule
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
    **[] $VALUES;
    public *;
}


# ----------------------------------------
# GSON
# ----------------------------------------
-keepattributes Signature
-dontwarn org.androidannotations.api.rest.**
-keepattributes *Annotation*
-keepattributes EnclosingMethod
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }
-keep class com.google.gson.FieldNamingStrategy { *; }
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer
-keep class com.kct.box.mvp.model.** { *; }

# ----------------------------------------
# Libs
# ----------------------------------------
-keep class com.google.android.exoplayer.** { *; }
-keep class com.github.aakira.expandablelayout.** { *; }
-keep class jp.wasabeef.glide.transformations.** { *; }
-keep class com.kct.box.lib.** { *; }
-dontwarn jp.wasabeef.glide.transformations.**
-keep class okio.** { *; }
-keep class com.kct.box.lib.tab.** { *; }
-keep class com.google.gson.**{ *; }
-keep class com.github.moduth.blockcanary.**{ *; }
-dontwarn com.github.moduth.blockcanary.**
-keep class com.google.zxing.**{ *; }
-keep class okio.**{ *; }
-dontwarn okio.**
-keep class rx.**{ *; }
-dontwarn rx.**

#TikXML
-keep class com.tickaroo.tikxml.** { *; }
-keep class **$$TypeAdapter { *; }

-keepclasseswithmembernames class * {
    @com.tickaroo.tikxml.* <fields>;
}

-keepclasseswithmembernames class * {
    @com.tickaroo.tikxml.* <methods>;
}
#Fresco
-keep,allowobfuscation @interface com.facebook.common.internal.DoNotStrip
-keep @com.facebook.common.internal.DoNotStrip class *
-keepclassmembers class * {
    @com.facebook.common.internal.DoNotStrip *;
}
-keepclassmembers class * {
    native <methods>;
}
-dontwarn okio.**
-dontwarn com.squareup.okhttp.**
-dontwarn okhttp3.**
-dontwarn javax.annotation.**
-dontwarn com.android.volley.toolbox.**
-dontwarn com.facebook.infer.**

#Stetho
-keep class com.facebook.stetho.** { *; }
-keep class com.uphyca.** { *; }
-dontwarn com.facebook.stetho.**
