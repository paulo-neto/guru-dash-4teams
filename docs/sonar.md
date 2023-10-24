## SONAR Details

### The Meta should be configured as follows:
```
{
  "key": "123",
  "url": "URL Sonar",
  "projects": [
    "project keys"
  ],
  "metrics": [
    "tests",
    "coverage",
    "sqale_index",
    "lines",
    "complexity",
    "cognitive_complexity",
    "duplicated_lines_density",
    "duplicated_blocks",
    "code_smells",
    "new_code_smells",
    "vulnerabilities",
    "bugs",
    "sqale_debt_ratio",
    "reliability_rating",
    "security_rating",
    "sqale_rating",
    "blocker_violations",
    "critical_violations"
  ]
}
```
#### Provider name: sonar

These are the minimum metrics required for the solution's standard dashboards to function. If you want to import more metrics, this is allowed. Just add to the metrics list. If you want fewer metrics than standards, this is also allowed, but standard dashboards will not have all of your data loaded.

#### metrics-config

Service that manages the metrics settings to be collected. Offers three end-points for managing metrics configurations:
- POST /api/v1/metrics-config
Creates a new metric configuration

- PUT /api/v1/metrics-config/provider/{provider}
Edit an existing metric

- GET /api/v1/metrics-config
Query existing metric settings