package ru.resodostudios.cashsense

import ru.resodostudios.cashsense.baselineprofile.BuildConfig

// نام پکیجی که Benchmark باید روی دستگاه پیدا کند، با Application ID پول‌یار یکسان است.
val PACKAGE_NAME = buildString {
    append("com.asteam.poolyar")
    append(BuildConfig.APP_FLAVOR_SUFFIX)
}
