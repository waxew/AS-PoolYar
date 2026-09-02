# نقشه راه AS-PoolYar

## فاز 1 — جداسازی برند و هویت برنامه

- [x] تغییر نام Gradle Project به AS-PoolYar
- [x] تغییر Application ID به `com.asteam.poolyar`
- [x] شروع نسخهٔ مستقل با `versionCode=1` و `versionName=1.0.0`
- [x] افزودن زبان `fa` به Locale Filter
- [x] افزودن نام فارسی «پول‌یار»
- [x] اصلاح Google Services placeholder برای Package جدید
- [x] اصلاح Package هدف Baseline Profile
- [x] بازنویسی README و AGENTS با هویت AS Team
- [ ] Refactor کامل Namespace داخلی از `ru.resodostudios.cashsense` به Namespace اختصاصی AS Team

## فاز 2 — UI مشترک AS Team

- [ ] Drawer سمت راست با دکمه همبرگری بالا-راست
- [ ] پروفایل دایره‌ای و انتخاب تصویر
- [ ] خانه
- [ ] دسته‌بندی‌ها و بخش‌های مالی مرتبط
- [ ] پرداخت‌های دوره‌ای
- [ ] تنظیمات
- [ ] اشتراک‌گذاری برنامه
- [ ] درباره نرم‌افزار + نسخه + Develop by AS Team Group
- [ ] تماس با ما با `AS.Developers.Support@Gmail.Com`
- [ ] خروج

## فاز 3 — فارسی‌سازی محصول

- [ ] ترجمه کامل Localeهای اصلی مورد استفاده در UI به فارسی
- [ ] RTL QA برای تمام Screenها و Dialogها
- [ ] فرمت سه‌رقمی مبلغ
- [ ] بررسی تقویم/تاریخ و نیاز به شمسی‌سازی در نمایش‌های فارسی

## فاز 4 — پایداری و آپدیت‌پذیری

- [ ] تست Room Migration و حفظ اطلاعات کاربر
- [ ] تست Backup/Restore
- [ ] تست نصب نسخه جدید روی نسخه قدیمی
- [ ] اصلاح SigningConfig و حذف امضای Debug از Release نهایی
- [ ] تعریف Versioning پایدار
- [ ] تست Back Navigation در همه مسیرها

## فاز 5 — Build و Release

- [ ] اجرای Unit Test
- [ ] اجرای Lint
- [ ] Build نسخه Debug
- [ ] Build نسخه Release
- [ ] امضای Release با Keystore اختصاصی AS Team
- [ ] تولید APK نهایی، checksum و گزارش verify signature

## Attribution

کدبیس اولیه از Cash Sense با مجوز Apache License 2.0 گرفته شده است. Attribution و فایل LICENSE باید حفظ شوند.
