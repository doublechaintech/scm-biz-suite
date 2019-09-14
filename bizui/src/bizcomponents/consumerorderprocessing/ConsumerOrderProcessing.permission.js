

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
import styles from './ConsumerOrderProcessing.profile.less'
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
const internalSummaryOf = (consumerOrderProcessing,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{consumerOrderProcessing.id}</Description> 
<Description term="谁">{consumerOrderProcessing.who}</Description> 
<Description term="过程的时间">{ moment(consumerOrderProcessing.processTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = consumerOrderProcessing => {
  const {ConsumerOrderProcessingBase} = GlobalComponents
  return <PermissionSetting targetObject={consumerOrderProcessing}  targetObjectMeta={ConsumerOrderProcessingBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class ConsumerOrderProcessingPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  consumerOrderProcessing = this.props.consumerOrderProcessing
    const { id,displayName,  } = consumerOrderProcessing
    const  returnURL = `/consumerOrderProcessing/${id}/dashboard`
    const cardsData = {cardsName:"消费者的订单处理",cardsFor: "consumerOrderProcessing",cardsSource: consumerOrderProcessing,displayName,returnURL,
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
  consumerOrderProcessing: state._consumerOrderProcessing,
}))(Form.create()(ConsumerOrderProcessingPermission))

