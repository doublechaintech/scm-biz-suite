

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'

import {Form } from 'antd'
import { Link } from 'dva/router'

import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './TransportTruck.preference.less'
import DescriptionList from '../../components/DescriptionList';

import DashboardTool from '../../common/Dashboard.tool'
import appLocaleName from '../../common/Locale.tool'

const {
  defaultRenderExtraHeader,
  defaultSubListsOf,

}= DashboardTool

const { Description } = DescriptionList;

const internalRenderExtraHeader = defaultRenderExtraHeader

const internalSubListsOf = defaultSubListsOf


const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}


const internalSummaryOf = (transportTruck,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{transportTruck.id}</Description> 
<Description term="名称">{transportTruck.name}</Description> 
<Description term="车牌号码">{transportTruck.plateNumber}</Description> 
<Description term="联系电话">{transportTruck.contactNumber}</Description> 
<Description term="汽车牌照号码">{transportTruck.vehicleLicenseNumber}</Description> 
<Description term="发动机号">{transportTruck.engineNumber}</Description> 
<Description term="制造日期">{ moment(transportTruck.makeDate).format('YYYY-MM-DD')}</Description> 
<Description term="里程">{transportTruck.mileage}</Description> 
<Description term="车身颜色">{transportTruck.bodyColor}</Description> 
	
      </DescriptionList>
	)
}



class TransportTruckProfile extends Component {

  
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  transportTruck = this.props.transportTruck;
    const { id,displayName, transportTaskCount } = transportTruck

    const cardsData = {cardsName:"运输车",cardsFor: "transportTruck",cardsSource: transportTruck,
  		subItems: [
    
      	],
  	};
    
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const subListsOf = this.props.subListsOf || internalSubListsOf
    const summaryOf = this.props.summaryOf || internalSummaryOf
    
    return (

      <PageHeaderLayout
        title={`${cardsData.cardsName}: ${displayName}`}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
       {subListsOf(cardsData)} 
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  transportTruck: state._transportTruck,
}))(Form.create()(TransportTruckProfile))

