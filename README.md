## Persistence and Analytics Fundamentals - Order Details Application
### mySQL Query

SELECT
    o.id as order_id,
    DATE_FORMAT(o.order_date, "%d/%m/%Y") as order_date,
    o.customer_id as customer_id,
    sum(od.quantity * od.unit_price) as total_price,
    sum(od.quantity * od.unit_price * od.discount) as discount,
    sum(od.quantity * od.unit_price) - sum(od.quantity * od.unit_price * od.discount) as discounted_price,
    sum(od.quantity * p.standard_cost) as cost_price
FROM
    orders o,
    order_details od,
    products p
WHERE
    o.id = od.order_id
        AND od.product_id = p.id
	and o.id = 30

use northwind

### Deploying to Railway
1. railway init
2. railway login
3. railway up

use this command to check snapshot.jar
*DO NOT CHANGE THE /APP/TARGET*
1. mvn package -Dmaven.test.skip=true

### Populate SQL data
1. copy and run .sql and -data.sql query
2. use "northwind"
