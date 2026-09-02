# AS-PoolYar Build و Release Checklist

## قبل از Build

- [x] Application ID مستقل
- [x] Versioning اولیه
- [x] GitHub Actions Build Check
- [ ] اجرای موفق Gradle Build
- [ ] رفع تمام خطاهای Compile

## Debug

- [ ] assembleDebug
- [ ] نصب روی دستگاه واقعی
- [ ] تست Navigation
- [ ] تست Back Button
- [ ] تست RTL

## Release

- [ ] Keystore اختصاصی AS Team
- [ ] SigningConfig واقعی
- [ ] assembleRelease
- [ ] R8/ProGuard validation
- [ ] SHA-256 checksum
- [ ] Signature verification

## تست آپدیت

- نصب نسخه قدیمی
- ایجاد داده کاربر
- نصب نسخه جدید
- بررسی حفظ اطلاعات

## انتشار

- GitHub Release
- APK Release
- Changelog
- README نهایی
