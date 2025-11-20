SELECT
	res.reservationtime,
	res.numberofguests,
	cus.firstName,
	cus.lastName,
	tab.tableNumber,
	tab.description
FROM reservation as res
INNER JOIN customer as cus on cus.id = res.customer_id
INNER JOIN restauranttable as tab on res.restauranttable_id = tab.id
WHERE tab.tablenumber = 4;