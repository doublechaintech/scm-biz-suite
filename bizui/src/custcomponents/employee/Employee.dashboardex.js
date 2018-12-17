/*
把以下代码贴到customindex.js里面去
import EmployeeDashboard from './employee/Employee.dashboardex';
import EmployeeBizApp from './employee/Employee.appex';

在customindex增加的esult

const result = {
EmployeeDashboard,
EmployeeBizApp

};

*/

import EmployeeDashboard from '../../bizcomponents/employee/Employee.dashboard'
import { List, Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch  } from 'antd'

import React, { Component } from 'react'
import { connect } from 'dva'
import styles from './Employee.dashboardex.less'
import { Link, Route, Redirect} from 'dva/router'
import FontAwesome from 'react-fontawesome';

const imageListOf = (employee) =>{

  return null

}

const renderExtraHeader = employee => {
  const targetId = employee.id
  
  if(!employee.employeeWorkingStoreList){

    return <div>稍等...</div>

  }

  /*

  const functions=[
    {name:'借书',link:`/employee/${targetId}/about/1`,icon:"download"},
    

  ];*/

  const functions=employee.employeeWorkingStoreList.map(item=>{
    const name=item.store.displayName

    const id=item.store.id
    const link=`/store/${id}/dashboard`
    const icon="store"
    return {name,link,icon}

  })
  /*
  
  */

  return (

    <List
    grid={{ gutter: 16, xs: 1, sm: 2, md: 4, lg: 6, xl: 8, xxl: 12 }}
    dataSource={functions}
    renderItem={item => (
      <List.Item>
        <Card title={item.name}><Link to={item.link}>
        
        <FontAwesome name={item.icon} style={{ fontSize: 50, color: '#08c' }}/>
        
        
       
       </Link></Card>
      </List.Item>
    )}
  />



   
  )
};

class EmployeeDashboardEx extends Component {

  render() {
    return (<EmployeeDashboard imageListOf={imageListOf} renderExtraHeader={renderExtraHeader}/>)
  }


}

export default connect(state => ({
  employee: state._employee,
}))(EmployeeDashboardEx)



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
import styles from './Employee.dashboard.less'
import DescriptionList from '../../components/DescriptionList';
import ImagePreview from '../../components/ImagePreview';
const { Description } = DescriptionList;
const { TabPane } = Tabs
const { RangePicker } = DatePicker

*/

