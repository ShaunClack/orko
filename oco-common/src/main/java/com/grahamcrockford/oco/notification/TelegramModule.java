package com.grahamcrockford.oco.notification;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.multibindings.Multibinder;
import com.grahamcrockford.oco.OrkoConfiguration;

import io.dropwizard.lifecycle.Managed;

public class TelegramModule extends AbstractModule {
  @Override
  protected void configure() {
    Multibinder.newSetBinder(binder(), Managed.class).addBinding().to(TelegramNotificationsTask.class);
  }

  @Provides
  TelegramConfiguration telegramConfig(OrkoConfiguration configuration) {
    return configuration.getTelegram();
  }
}
