package com.ciandt.metrics_config.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciandt.metrics_config.model.MetricConfig;
import com.ciandt.metrics_config.model.MetricTypeEnum;

public interface IMetricsConfigRepository extends JpaRepository<MetricConfig, Long> {

    public MetricConfig findByProvider(MetricTypeEnum provider);
}
