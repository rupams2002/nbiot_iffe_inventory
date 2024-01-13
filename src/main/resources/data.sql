CREATE TABLE nbiot_iffe_inventory (
  fiber_id int ,
  fwd_link_op_status varchar(10) ,
  fwd_link_status varchar(10) ,
  lhcp_link_op_status varchar(10) ,
  lhcp_link_status varchar(10) ,
  rhcp_link_op_status varchar(10),
  rhcp_link_status varchar(10)  
);



INSERT INTO nbiot_iffe_inventory (fiber_id, fwd_link_op_status, fwd_link_status, lhcp_link_op_status, lhcp_link_status, rhcp_link_op_status, rhcp_link_status) 
VALUES (0, 'DOWN', 'STANDBY', 'UP', 'ACTIVE',  'DOWN', 'STANDBY');
