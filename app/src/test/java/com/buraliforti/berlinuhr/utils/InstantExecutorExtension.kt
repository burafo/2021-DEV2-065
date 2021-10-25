package com.buraliforti.berlinuhr.utils

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.runner.Description

class InstantExecutorExtension : InstantTaskExecutorRule(), BeforeEachCallback, AfterEachCallback {

    override fun beforeEach(context: ExtensionContext?) = starting(Description.EMPTY)

    override fun afterEach(context: ExtensionContext?) = finished(Description.EMPTY)
}