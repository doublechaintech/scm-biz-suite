/*
把以下代码贴到customindex.js里面去
import BookTakeStockPlanDashboard from './booktakestockplan/BookTakeStockPlan.dashboardex';
import BookTakeStockPlanBizApp from './booktakestockplan/BookTakeStockPlan.appex';

在customindex增加的esult

const result = {
BookTakeStockPlanDashboard,
BookTakeStockPlanBizApp

};

*/

import BookTakeStockPlanDashboard from '../../bizcomponents/booktakestockplan/BookTakeStockPlan.dashboard'
import { List, Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch  } from 'antd'

import React, { Component } from 'react'
import { connect } from 'dva'
import styles from './BookTakeStockPlan.dashboardex.less'
import { Link, Route, Redirect} from 'dva/router'
const renderExtraHeader = bookTakeStockPlan => {
  const targetId = bookTakeStockPlan.id
  const functions=[
    
    {name:'盘点',link:`/bookTakeStockPlan/${targetId}/takestock`,icon:"calculator"}

  ];

  return (

    <List
    grid={{ gutter: 16, xs: 1, sm: 2, md: 4, lg: 6, xl: 8, xxl: 12 }}
    dataSource={functions}
    renderItem={item => (
      <List.Item>
        <Card title={item.name}><Link to={item.link}>
        
        <Icon type={item.icon} style={{ fontSize: 50, color: '#08c' }}/>
        
        
       
       </Link></Card>
      </List.Item>
    )}
  />



   
  )
};

class BookTakeStockPlanDashboardEx extends Component {

  render() {
    return (<BookTakeStockPlanDashboard renderExtraHeader={renderExtraHeader}/>)
  }


}

export default connect(state => ({
  bookTakeStockPlan: state._bookTakeStockPlan,
}))(BookTakeStockPlanDashboardEx)



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
import styles from './BookTakeStockPlan.dashboard.less'
import DescriptionList from '../../components/DescriptionList';
import ImagePreview from '../../components/ImagePreview';
const { Description } = DescriptionList;
const { TabPane } = Tabs
const { RangePicker } = DatePicker

*/

