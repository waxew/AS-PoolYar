# AS-PoolYar Project Guide

`AS-PoolYar / پول‌یار` یک اپلیکیشن Android مدیریت مالی شخصی است که از کدبیس متن‌باز Cash Sense منشعب شده و برای AS Team فارسی‌سازی و شخصی‌سازی می‌شود.

## هدف محصول

کاربر باید بتواند بدون وابستگی دائمی به سرور، کیف‌پول‌ها، درآمدها، هزینه‌ها، دسته‌بندی‌ها، انتقال‌ها و پرداخت‌های دوره‌ای خود را مدیریت کند. حفظ داده‌های محلی در آپدیت‌های آینده یک الزام اصلی است.

## معماری

- Kotlin + Jetpack Compose + Material 3
- Single Activity و Navigation 3
- Clean Architecture و UDF
- Hilt برای Dependency Injection
- Room و DataStore برای دادهٔ محلی
- WorkManager برای پردازش پس‌زمینه
- Coroutines و Flow برای State و جریان داده

## قواعد AS Team

- Application ID محصول: `com.asteam.poolyar`
- نام نمایشی: `پول‌یار`
- تمام تغییرات سورس باید استاندارد `docs/FA_COMMENTING_GUIDE.md` را رعایت کنند.
- Back باید به صفحهٔ قبلی برگردد و بدون دلیل از برنامه خارج نشود.
- فرمت مبالغ باید خوانا و دارای جداکنندهٔ سه‌رقمی باشد.
- ساختار داده و Migrationها باید آپدیت‌خور باشند و دادهٔ کاربر حذف نشود.
- Release نهایی نباید با کلید Debug منتشر شود.
- Drawer مشترک AS Team در سمت راست قرار می‌گیرد و شامل پروفایل، خانه، تنظیمات، اشتراک‌گذاری، درباره نرم‌افزار، تماس با ما و خروج است؛ آیتم‌های مالی مرتبط با همین پروژه نیز به آن افزوده می‌شوند.
- ایمیل پیش‌فرض پشتیبانی: `AS.Developers.Support@Gmail.Com`

## ساختار ماژول‌ها

- `mobile/`: اپلیکیشن اصلی Android
- `feature/`: قابلیت‌های مستقل مانند Home، Wallet، Transaction، Category، Subscription و Settings
- `core/`: دیتابیس، دیتا، دامنه، Design System، Locale، Navigation و سرویس‌های مشترک
- `work/`: وظایف WorkManager
- `baselineprofile/`: Benchmark و Baseline Profile

## منبع اولیه و مجوز

کدبیس اولیه از `https://github.com/nikbulavin/cashsense` با مجوز Apache License 2.0 آمده است. `LICENSE` و attribution مربوط به منبع اولیه باید حفظ شوند.
