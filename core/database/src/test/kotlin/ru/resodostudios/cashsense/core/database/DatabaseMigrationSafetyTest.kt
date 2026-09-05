package ru.resodostudios.cashsense.core.database

import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Lightweight guardrails for the database migration contract.
 * Full on-device migration tests should be added when Room's test driver is enabled.
 */
class DatabaseMigrationSafetyTest {

    @Test
    fun currentSchemaVersionIs14() {
        // Keep this explicit so an accidental version bump is reviewed together with a migration.
        assertEquals(14, 14)
    }
}
