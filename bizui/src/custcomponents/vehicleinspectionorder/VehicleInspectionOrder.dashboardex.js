

import VehicleInspectionOrderDashboard from '../../bizcomponents/vehicleinspectionorder/VehicleInspectionOrder.dashboard'
import { List, Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch  } from 'antd'

import React, { Component } from 'react'
import { connect } from 'dva'
import styles from './VehicleInspectionOrder.dashboardex.less'
import { Link, Route, Redirect} from 'dva/router'
const renderExtraHeader = vehicleInspectionOrder => {
  const targetId = vehicleInspectionOrder.id
  //vehicleInspectionOrderManager/printChargeList/VIO000001/
  const functions=[
    {name:'打印',link:`/cis/vehicleInspectionOrderManager/printChargeList/${targetId}/`,icon:"printer"},
    
  ];

  return (

    <List
    grid={{ gutter: 16, xs: 1, sm: 2, md: 4, lg: 6, xl: 8, xxl: 12 }}
    dataSource={functions}
    renderItem={item => (
      <List.Item>
        <Card title={item.name}><a href={item.link}>
        
        <Icon type={item.icon} style={{ fontSize: 50, color: '#08c' }}/>
        
       </a></Card>
      </List.Item>
    )}
  />



   
  )
};

class VehicleInspectionOrderDashboardEx extends Component {

  render() {
    return (<VehicleInspectionOrderDashboard renderExtraHeader={renderExtraHeader}/>)
  }


}

export default connect(state => ({
  vehicleInspectionOrder: state._vehicleInspectionOrder,
}))(VehicleInspectionOrderDashboardEx)



/*

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from 'components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch  } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'
import {
  ChartCard, yuan, MiniArea, MiniBar, MiniProgress, Field, Bar, Pie, TimelineChart,
} from '../../components/Charts'
import Trend from '../../components/Trend'
import NumberInfo from '../../components/NumberInfo'
import { getTimeDistance } from '../../utils/utils'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './VehicleInspectionOrder.dashboard.less'
import DescriptionList from '../../components/DescriptionList';
import ImagePreview from '../../components/ImagePreview';
const { Description } = DescriptionList;
const { TabPane } = Tabs
const { RangePicker } = DatePicker

*/

