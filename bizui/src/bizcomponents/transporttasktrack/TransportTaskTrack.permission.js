

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from 'components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './TransportTaskTrack.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (transportTaskTrack,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{transportTaskTrack.id}</Description> 
<Description term="跟踪时间">{ moment(transportTaskTrack.trackTime).format('YYYY-MM-DD')}</Description> 
<Description term="纬度">{transportTaskTrack.latitude}</Description> 
<Description term="经度">{transportTaskTrack.longitude}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = transportTaskTrack => {
  const {TransportTaskTrackBase} = GlobalComponents
  return <PermissionSetting targetObject={transportTaskTrack}  targetObjectMeta={TransportTaskTrackBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class TransportTaskTrackPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  transportTaskTrack = this.props.transportTaskTrack;
    const { id,displayName,  } = transportTaskTrack
    const cardsData = {cardsName:"运输任务跟踪",cardsFor: "transportTaskTrack",cardsSource: transportTaskTrack,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={`${cardsData.cardsName}: ${displayName}`}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
      {renderPermissionSetting(cardsData.cardsSource)}
      
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  transportTaskTrack: state._transportTaskTrack,
}))(Form.create()(TransportTaskTrackPermission))

