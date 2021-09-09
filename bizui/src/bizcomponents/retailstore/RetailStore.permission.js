

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
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

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}
const internalSummaryOf = (retailStore,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{retailStore.id}</Description> 
<Description term="名称">{retailStore.name}</Description> 
<Description term="电话">{retailStore.telephone}</Description> 
<Description term="业主">{retailStore.owner}</Description> 
<Description term="成立">{ moment(retailStore.founded).format('YYYY-MM-DD')}</Description> 
<Description term="纬度">{retailStore.latitude}</Description> 
<Description term="经度">{retailStore.longitude}</Description> 
<Description term="描述">{retailStore.description}</Description> 
<Description term="更新于">{ moment(retailStore.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
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
    const  retailStore = this.props.retailStore
    const { id,displayName, consumerOrderCount, retailStoreOrderCount, goodsCount, transportTaskCount, accountSetCount } = retailStore
    const  returnURL = `/retailStore/${id}/workbench`
    const cardsData = {cardsName:"双链小超",cardsFor: "retailStore",cardsSource: retailStore,displayName,returnURL,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={internalRenderTitle(cardsData,this)}
       
        wrapperClassName={styles.advancedForm}
      >
      
      {renderPermissionSetting(cardsData.cardsSource)}
      
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  retailStore: state._retailStore,
}))(Form.create()(RetailStorePermission))

