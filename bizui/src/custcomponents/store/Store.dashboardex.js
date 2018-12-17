

//import StoreDashboard from '../../bizcomponents/store/Store.dashboard'
import StoreDashboard from '../../bizcomponents/store/Store.dashboard'

import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch  } from 'antd'

import React, { Component } from 'react'
import { connect } from 'dva'
import styles from './Store.dashboardex.less'
import { Link, Route, Redirect} from 'dva/router'
const  renderExtraHeaderEx = (store) => {

  return (

    <div>
    <Card title="常用功能" className={styles.card} bordered={false}>
       <Link to={`/store/${store.id}/about`}> 关于 </Link>  
     </Card>
  </div>
  )

}

class StoreDashboardEx extends Component {

  render() {

    return (<StoreDashboard 
      renderExtraHeaderEx={renderExtraHeaderEx}/>)
  }


}

export default connect(state => ({
  store: state._store,
}))(StoreDashboardEx)



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
import styles from './Store.dashboard.less'
import DescriptionList from '../../components/DescriptionList';
import ImagePreview from '../../components/ImagePreview';
const { Description } = DescriptionList;
const { TabPane } = Tabs
const { RangePicker } = DatePicker

*/

