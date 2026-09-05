# AS-PoolYar database

## Migration policy

The database schema is currently at version 14. Existing migration history must remain intact for users upgrading from older releases.

- Do not delete or rewrite an existing migration.
- Every schema change must increment the Room database version.
- Destructive changes require an explicit migration and data-preservation review.
- Exported Room schemas under `schemas/` are part of the migration contract.
- Custom migrations (`Schema11to12` and `Schema13to14`) are registered in `DatabaseModule` because they require SQL/data transformation.

Before a production release, migration tests should cover the oldest supported schema and the current schema, including transactions, wallets, categories, subscriptions, and currency exchange rates.
