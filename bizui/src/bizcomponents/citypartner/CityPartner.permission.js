

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
import styles from './CityPartner.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (cityPartner,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{cityPartner.id}</Description> 
<Description term="名称">{cityPartner.name}</Description> 
<Description term="手机">{cityPartner.mobile}</Description> 
<Description term="描述">{cityPartner.description}</Description> 
<Description term="最后更新时间">{ moment(cityPartner.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = cityPartner => {
  const {CityPartnerBase} = GlobalComponents
  return <PermissionSetting targetObject={cityPartner}  targetObjectMeta={CityPartnerBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class CityPartnerPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  cityPartner = this.props.cityPartner;
    const { id,displayName, potentialCustomerCount, potentialCustomerContactCount } = cityPartner
    const cardsData = {cardsName:"城市合伙人",cardsFor: "cityPartner",cardsSource: cityPartner,
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
  cityPartner: state._cityPartner,
}))(Form.create()(CityPartnerPermission))

