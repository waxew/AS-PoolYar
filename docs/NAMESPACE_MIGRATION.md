# Namespace Migration Plan

وضعیت فعلی:

- Application ID: `com.asteam.poolyar`
- Namespace داخلی: `ru.resodostudios.cashsense`

هدف نهایی:

تبدیل کامل تمام package ها به:

`com.asteam.poolyar`

مراحل:

1. ایجاد branch جداگانه برای Refactor.
2. تغییر namespace تمام ماژول‌های Android.
3. انتقال package های Kotlin.
4. اصلاح importها.
5. اصلاح Build Logic.
6. اصلاح Baseline Profile.
7. اجرای Build کامل.
8. تست Migration دیتابیس.

این تغییر بعد از پایدار شدن Build انجام می‌شود تا ریسک شکست چندماژوله کاهش پیدا کند.
