

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
import styles from './RetailStoreFranchising.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (retailStoreFranchising,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{retailStoreFranchising.id}</Description> 
<Description term="Comment">{retailStoreFranchising.comment}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = retailStoreFranchising => {
  const {RetailStoreFranchisingBase} = GlobalComponents
  return <PermissionSetting targetObject={retailStoreFranchising}  targetObjectMeta={RetailStoreFranchisingBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class RetailStoreFranchisingPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  retailStoreFranchising = this.props.retailStoreFranchising;
    const { id,displayName, retailStoreCount } = retailStoreFranchising
    const cardsData = {cardsName:"Retail Store Franchising",cardsFor: "retailStoreFranchising",cardsSource: retailStoreFranchising,
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
  retailStoreFranchising: state._retailStoreFranchising,
}))(Form.create()(RetailStoreFranchisingPermission))

