

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './RetailStoreCityServiceCenter.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}
const internalSummaryOf = (retailStoreCityServiceCenter,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{retailStoreCityServiceCenter.id}</Description> 
<Description term="名称">{retailStoreCityServiceCenter.name}</Description> 
<Description term="成立">{ moment(retailStoreCityServiceCenter.founded).format('YYYY-MM-DD')}</Description> 
<Description term="最后更新时间">{ moment(retailStoreCityServiceCenter.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = retailStoreCityServiceCenter => {
  const {RetailStoreCityServiceCenterBase} = GlobalComponents
  return <PermissionSetting targetObject={retailStoreCityServiceCenter}  targetObjectMeta={RetailStoreCityServiceCenterBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class RetailStoreCityServiceCenterPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  retailStoreCityServiceCenter = this.props.retailStoreCityServiceCenter
    const { id,displayName, cityPartnerCount, potentialCustomerCount, cityEventCount, retailStoreCount } = retailStoreCityServiceCenter
    const  returnURL = `/retailStoreCityServiceCenter/${id}/dashboard`
    const cardsData = {cardsName:"双链小超城市服务中心",cardsFor: "retailStoreCityServiceCenter",cardsSource: retailStoreCityServiceCenter,displayName,returnURL,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={internalRenderTitle(cardsData,this)}
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
  retailStoreCityServiceCenter: state._retailStoreCityServiceCenter,
}))(Form.create()(RetailStoreCityServiceCenterPermission))

