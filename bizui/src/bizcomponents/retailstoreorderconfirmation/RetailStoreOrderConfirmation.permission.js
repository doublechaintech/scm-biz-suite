

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
import styles from './RetailStoreOrderConfirmation.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (retailStoreOrderConfirmation,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{retailStoreOrderConfirmation.id}</Description> 
<Description term="谁">{retailStoreOrderConfirmation.who}</Description> 
<Description term="确认时间">{ moment(retailStoreOrderConfirmation.confirmTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = retailStoreOrderConfirmation => {
  const {RetailStoreOrderConfirmationBase} = GlobalComponents
  return <PermissionSetting targetObject={retailStoreOrderConfirmation}  targetObjectMeta={RetailStoreOrderConfirmationBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class RetailStoreOrderConfirmationPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  retailStoreOrderConfirmation = this.props.retailStoreOrderConfirmation;
    const { id,displayName, retailStoreOrderCount } = retailStoreOrderConfirmation
    const cardsData = {cardsName:"生超订单确认",cardsFor: "retailStoreOrderConfirmation",cardsSource: retailStoreOrderConfirmation,
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
  retailStoreOrderConfirmation: state._retailStoreOrderConfirmation,
}))(Form.create()(RetailStoreOrderConfirmationPermission))

