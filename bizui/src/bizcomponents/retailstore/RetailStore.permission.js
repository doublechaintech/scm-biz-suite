

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
import styles from './RetailStore.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (retailStore,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{retailStore.id}</Description> 
<Description term="Name">{retailStore.name}</Description> 
<Description term="Telephone">{retailStore.telephone}</Description> 
<Description term="Owner">{retailStore.owner}</Description> 
<Description term="Founded">{ moment(retailStore.founded).format('YYYY-MM-DD')}</Description> 
<Description term="Latitude">{retailStore.latitude}</Description> 
<Description term="Longitude">{retailStore.longitude}</Description> 
<Description term="Description">{retailStore.description}</Description> 
<Description term="Last Update Time">{ moment(retailStore.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
<Description term="Current Status">{retailStore.currentStatus}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = retailStore => {
  const {RetailStoreBase} = GlobalComponents
  return <PermissionSetting targetObject={retailStore}  targetObjectMeta={RetailStoreBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class RetailStorePermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  retailStore = this.props.retailStore;
    const { id,displayName, consumerOrderCount, retailStoreOrderCount, goodsCount, transportTaskCount, accountSetCount } = retailStore
    const cardsData = {cardsName:"Retail Store",cardsFor: "retailStore",cardsSource: retailStore,
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
  retailStore: state._retailStore,
}))(Form.create()(RetailStorePermission))

