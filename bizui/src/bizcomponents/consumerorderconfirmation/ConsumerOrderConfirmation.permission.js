

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
import styles from './ConsumerOrderConfirmation.profile.less'
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
const internalSummaryOf = (consumerOrderConfirmation,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{consumerOrderConfirmation.id}</Description> 
<Description term="谁">{consumerOrderConfirmation.who}</Description> 
<Description term="确认时间">{ moment(consumerOrderConfirmation.confirmTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = consumerOrderConfirmation => {
  const {ConsumerOrderConfirmationBase} = GlobalComponents
  return <PermissionSetting targetObject={consumerOrderConfirmation}  targetObjectMeta={ConsumerOrderConfirmationBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class ConsumerOrderConfirmationPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  consumerOrderConfirmation = this.props.consumerOrderConfirmation
    const { id,displayName,  } = consumerOrderConfirmation
    const  returnURL = `/consumerOrderConfirmation/${id}/dashboard`
    const cardsData = {cardsName:"客户订单确认",cardsFor: "consumerOrderConfirmation",cardsSource: consumerOrderConfirmation,displayName,returnURL,
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
  consumerOrderConfirmation: state._consumerOrderConfirmation,
}))(Form.create()(ConsumerOrderConfirmationPermission))

