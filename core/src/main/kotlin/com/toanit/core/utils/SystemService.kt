/*
 * Copyright (C) 2015 Mobs & Geeks
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.celites.kutils

import android.accounts.AccountManager
import android.annotation.TargetApi
import android.app.*
import android.app.admin.DevicePolicyManager
import android.app.job.JobScheduler
import android.appwidget.AppWidgetManager
import android.bluetooth.BluetoothManager
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.WIFI_SERVICE
import android.content.RestrictionsManager
import android.content.pm.LauncherApps
import android.hardware.ConsumerIrManager
import android.hardware.SensorManager
import android.hardware.camera2.CameraManager
import android.hardware.display.DisplayManager
import android.hardware.input.InputManager
import android.hardware.usb.UsbManager
import android.location.LocationManager
import android.media.AudioManager
import android.media.MediaRouter
import android.media.projection.MediaProjectionManager
import android.media.session.MediaSessionManager
import android.media.tv.TvInputManager
import android.net.ConnectivityManager
import android.net.nsd.NsdManager
import android.net.wifi.WifiManager
import android.net.wifi.p2p.WifiP2pManager
import android.nfc.NfcManager
import android.os.*
import android.os.storage.StorageManager
import android.print.PrintManager
import android.service.wallpaper.WallpaperService
import android.support.annotation.RequiresApi
import android.telecom.TelecomManager
import android.telephony.TelephonyManager
import android.view.LayoutInflater
import android.view.WindowManager
import android.view.accessibility.AccessibilityManager
import android.view.accessibility.CaptioningManager
import android.view.inputmethod.InputMethodManager
import android.view.textservice.TextServicesManager


public val Context.accessibilityManager: AccessibilityManager?
    get() =
    getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager

public val Context.accountManager: AccountManager?
    get() =
    getSystemService(Context.ACCOUNT_SERVICE) as AccountManager

public val Context.activityManager: ActivityManager
    get() =
    getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

public val Context.alarmManager: AlarmManager
    get() =
    getSystemService(Context.ALARM_SERVICE) as AlarmManager

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public fun Context.appWidgetManager(): AppWidgetManager? =
        getSystemService(Context.APPWIDGET_SERVICE) as AppWidgetManager

@TargetApi(Build.VERSION_CODES.KITKAT)
public fun Context.appOpsManager(): AppOpsManager? =
        getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager

public val Context.audioManager: AudioManager
    get() =
    getSystemService(Context.AUDIO_SERVICE) as AudioManager

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public fun Context.batteryManager(): BatteryManager? =
        getSystemService(Context.BATTERY_SERVICE) as BatteryManager

@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
public fun Context.bluetoothAdapter(): BluetoothManager? =
        getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public fun Context.cameraManager(): CameraManager? =
        getSystemService(Context.CAMERA_SERVICE) as CameraManager

@TargetApi(Build.VERSION_CODES.KITKAT)
public fun Context.captioningManager(): CaptioningManager? =
        getSystemService(Context.CAPTIONING_SERVICE) as CaptioningManager

public val Context.clipboardManager: ClipboardManager
    get() =
    getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

public val Context.connectivityManager: ConnectivityManager
    get() =
    getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

@TargetApi(Build.VERSION_CODES.KITKAT)
public fun Context.consumerIrManager(): ConsumerIrManager? =
        getSystemService(Context.CONSUMER_IR_SERVICE) as ConsumerIrManager

public val Context.devicePolicyManager: DevicePolicyManager?
    get() =
    getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager

@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
public fun Context.displayManager(): DisplayManager? =
        getSystemService(Context.DISPLAY_SERVICE) as DisplayManager

public val Context.downloadManager: DownloadManager?
    get() =
    getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

public val Context.dropBoxManager: DropBoxManager?
    get() =
    getSystemService(Context.DROPBOX_SERVICE) as DropBoxManager

public val Context.inputMethodManager: InputMethodManager?
    get() =
    getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
public fun Context.inputManager(): InputManager? =
        getSystemService(Context.INPUT_SERVICE) as InputManager

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public fun Context.jobScheduler(): JobScheduler? =
        getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler

public val Context.keyguardManager: KeyguardManager
    get() =
    getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public fun Context.launcherApps(): LauncherApps? =
        getSystemService(Context.LAUNCHER_APPS_SERVICE) as LauncherApps

public val Context.layoutInflater: LayoutInflater
    get() =
    getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

public val Context.locationManager: LocationManager
    get() =
    getSystemService(Context.LOCATION_SERVICE) as LocationManager

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public fun Context.mediaProjectionManager(): MediaProjectionManager? =
        getSystemService(Context.MEDIA_PROJECTION_SERVICE) as MediaProjectionManager

@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
public fun Context.mediaRouter(): MediaRouter? =
        getSystemService(Context.MEDIA_ROUTER_SERVICE) as MediaRouter

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public fun Context.mediaSessionManager(): MediaSessionManager? =
        getSystemService(Context.MEDIA_SESSION_SERVICE) as MediaSessionManager

public val Context.nfcManager: NfcManager?
    get() =
    getSystemService(Context.NFC_SERVICE) as NfcManager

public val Context.notificationManager: NotificationManager
    get() =
    getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
public fun Context.nsdManager(): NsdManager? =
        getSystemService(Context.NSD_SERVICE) as NsdManager

public val Context.powerManager: PowerManager
    get() =
    getSystemService(Context.POWER_SERVICE) as PowerManager

@TargetApi(Build.VERSION_CODES.KITKAT)
public fun Context.printManager(): PrintManager? =
        getSystemService(Context.PRINT_SERVICE) as PrintManager

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public fun Context.restrictionsManager(): RestrictionsManager? =
        getSystemService(Context.RESTRICTIONS_SERVICE) as RestrictionsManager

public val Context.searchManager: SearchManager
    get() =
    getSystemService(Context.SEARCH_SERVICE) as SearchManager

public val Context.sensorManager: SensorManager
    get() =
    getSystemService(Context.SENSOR_SERVICE) as SensorManager

public val Context.storageManager: StorageManager?
    get() =
    getSystemService(Context.STORAGE_SERVICE) as StorageManager

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public fun Context.telecomManager(): TelecomManager? =
        getSystemService(Context.TELECOM_SERVICE) as TelecomManager

public val Context.telephonyManager: TelephonyManager
    get() =
    getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

public val Context.textServicesManager: TextServicesManager?
    get() =
    getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE) as TextServicesManager

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
public fun Context.tvInputManager(): TvInputManager? =
        getSystemService(Context.TV_INPUT_SERVICE) as TvInputManager

public val Context.uiModeManager: UiModeManager?
    get() =
    getSystemService(Context.UI_MODE_SERVICE) as UiModeManager

public val Context.usbManager: UsbManager?
    get() =
    getSystemService(Context.USB_SERVICE) as UsbManager

@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
public fun Context.userManager(): UserManager? =
        getSystemService(Context.USER_SERVICE) as UserManager

public val Context.vibrator: Vibrator
    get() =
    getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

public val Context.wallpaperService: WallpaperService
    get() =
    getSystemService(Context.WALLPAPER_SERVICE) as WallpaperService

public val Context.wifiP2pManager: WifiP2pManager?
    get() =
    getSystemService(Context.WIFI_P2P_SERVICE) as WifiP2pManager

public val Context.wifiManager: WifiManager
    get() =
    applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager

public val Context.windowService: WindowManager
    get() =
    getSystemService(Context.WINDOW_SERVICE) as WindowManager
