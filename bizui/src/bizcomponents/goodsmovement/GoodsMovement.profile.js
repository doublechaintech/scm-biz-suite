

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'

import {Form } from 'antd'
import { Link } from 'dva/router'

import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './GoodsMovement.preference.less'
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


const internalSummaryOf = (goodsMovement,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{goodsMovement.id}</Description> 
<Description term="移动时间">{ moment(goodsMovement.moveTime).format('YYYY-MM-DD')}</Description> 
<Description term="设施">{goodsMovement.facility}</Description> 
<Description term="设备ID">{goodsMovement.facilityId}</Description> 
<Description term="从IP">{goodsMovement.fromIp}</Description> 
<Description term="会话ID">{goodsMovement.sessionId}</Description> 
<Description term="纬度">{goodsMovement.latitude}</Description> 
<Description term="经度">{goodsMovement.longitude}</Description> 
	
      </DescriptionList>
	)
}



class GoodsMovementProfile extends Component {

  
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  goodsMovement = this.props.goodsMovement;
    const { id,displayName,  } = goodsMovement

    const cardsData = {cardsName:"货物移动",cardsFor: "goodsMovement",cardsSource: goodsMovement,
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
  goodsMovement: state._goodsMovement,
}))(Form.create()(GoodsMovementProfile))

