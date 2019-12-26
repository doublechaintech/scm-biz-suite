import React, { Component } from 'react'
import { Card, Button, Form, Icon, Col, Row, DatePicker, TimePicker, Input, Select, Popover,Switch,Modal } from 'antd'
import { connect } from 'dva'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import {ImageComponent} from '../../axios/tools'
import FooterToolbar from '../../components/FooterToolbar'
import styles from './RetailStore.createform.less'
import {mapBackToImageValues, mapFromImageValues} from '../../axios/tools'
import GlobalComponents from '../../custcomponents';
import RetailStoreBase from './RetailStore.base'
import SelectObject from '../../components/SelectObject'
import appLocaleName from '../../common/Locale.tool'

const { Option } = Select
const { RangePicker } = DatePicker
const { TextArea } = Input

const testValues = {};
/*
const testValues = {
  name: '中和社区小超',
  telephone: '2114888874',
  owner: '吕刚',
<<<<<<< HEAD
  founded: '2017-02-05',
  latitude: '40.85512301217683',
  longitude: '131.0937893026664',
=======
  founded: '2019-05-09',
  latitude: '39.88523434760402',
  longitude: '129.36834730618446',
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  description: '啤酒饮料矿泉水，香肠瓜子方便面, 请让一让',
  retailStoreCountryCenterId: 'RSCC000001',
  cityServiceCenterId: 'RSCSC000001',
  creationId: 'RSC000001',
  investmentInvitationId: 'RSII000001',
  franchisingId: 'RSF000001',
  decorationId: 'RSD000001',
  openingId: 'RSO000001',
  closingId: 'RSC000001',
}
*/


const imageKeys = [
]


class RetailStoreAssociateForm extends Component {
  state = {
    previewVisible: false,
    previewImage: '',
    convertedImagesValues: {},
  }

  componentDidMount() {
 
    
    
    
  }

  handlePreview = (file) => {
    console.log('preview file', file)
    this.setState({
      previewImage: file.url || file.thumbUrl,
      previewVisible: true,
    })
  }

  



  handleChange = (event, source) => {
    console.log('get file list from change in update change:', source)

    const { fileList } = event
    const { convertedImagesValues } = this.state

    convertedImagesValues[source] = fileList
    this.setState({ convertedImagesValues })
    console.log('/get file list from change in update change:', source)
  }
	
  

  render() {
	const { form, dispatch, submitting, role,data,owner,toggleAssociatePaymentVisible,visible,onCancel, onCreate } = this.props
    const { convertedImagesValues } = this.state
    const {RetailStoreService} = GlobalComponents
    const userContext = null
    
 const {ConsumerOrderModalTable} = GlobalComponents;
 const {RetailStoreOrderModalTable} = GlobalComponents;
 const {GoodsModalTable} = GlobalComponents;
 const {TransportTaskModalTable} = GlobalComponents;
 const {AccountSetModalTable} = GlobalComponents;


    const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = form
    const {fieldLabels} = RetailStoreBase
    
    const capFirstChar = (value)=>{
    	//const upper = value.replace(/^\w/, c => c.toUpperCase());
  		const upper = value.charAt(0).toUpperCase() + value.substr(1);
  		return upper
  	}
    
    
    

    
    
    const tryinit  = (fieldName, candidates) => {
      
      if(candidates&&candidates.length==1){
          return candidates[0].id
      }
      const { owner } = this.props
      const { referenceName } = owner
      if(referenceName!=fieldName){
        return null
      }
      return owner.id
    }
    
    const availableForEdit= (fieldName) =>{
      const { owner } = this.props
      const { referenceName } = owner
      if(referenceName!=fieldName){
        return true
      }
      return false
    
    }
    const formItemLayout = {
      labelCol: { span: 6 },
      wrapperCol: { span: 12 },
    }
    const switchFormItemLayout = {
      labelCol: { span: 14 },
      wrapperCol: { span: 4 },
    }
   
    return (
 <Modal
          title={appLocaleName(userContext,"CreateNew")}
          visible={visible}
          onOk={onCancel}
          onCancel={onCancel}
          width={920}
          style={{ top: 40}}
        >
        <Card title={appLocaleName(userContext,"BasicInfo")}  className={styles.card} style={{ backgroundColor:"#eee" }}>
          <Form >
            <Row gutter={16}>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.name} {...formItemLayout}>
                  {getFieldDecorator('name', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <Input size="large" placeholder="名称" />
=======
                    <Input size="large"  placeHolder={fieldLabels.name} />
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.telephone} {...formItemLayout}>
                  {getFieldDecorator('telephone', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <Input size="large" placeholder="电话" />
=======
                    <Input size="large"  placeHolder={fieldLabels.telephone} />
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.owner} {...formItemLayout}>
                  {getFieldDecorator('owner', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <Input size="large" placeholder="业主" />
=======
                    <Input size="large"  placeHolder={fieldLabels.owner} />
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.founded} {...formItemLayout}>
                  {getFieldDecorator('founded', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <DatePicker size="large" format="YYYY-MM-DD" placeholder="成立" />
=======
                    <DatePicker size="large" format="YYYY-MM-DD"  placeHolder={fieldLabels.founded}/>
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.latitude} {...formItemLayout}>
                  {getFieldDecorator('latitude', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <Input size="large" placeholder="纬度" />
=======
                    <Input size="large"  placeHolder={fieldLabels.latitude} />
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.longitude} {...formItemLayout}>
                  {getFieldDecorator('longitude', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <Input size="large" placeholder="经度" />
=======
                    <Input size="large"  placeHolder={fieldLabels.longitude} />
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.description} {...formItemLayout}>
                  {getFieldDecorator('description', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <Input size="large" placeholder="描述" />
=======
                    <Input size="large"  placeHolder={fieldLabels.description} />
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  )}
                </Form.Item>
              </Col>

            </Row>


       
        









       
            <Row gutter={16}>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.retailStoreCountryCenter} {...formItemLayout}>
                  {getFieldDecorator('retailStoreCountryCenterId', {
                  	initialValue: tryinit('retailStoreCountryCenter'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('retailStoreCountryCenter')}
                    targetType={"retailStoreCountryCenter"} 
                    requestFunction={RetailStoreService.requestCandidateRetailStoreCountryCenter}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.cityServiceCenter} {...formItemLayout}>
                  {getFieldDecorator('cityServiceCenterId', {
                  	initialValue: tryinit('cityServiceCenter'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('cityServiceCenter')}
                    targetType={"cityServiceCenter"} 
                    requestFunction={RetailStoreService.requestCandidateCityServiceCenter}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.creation} {...formItemLayout}>
                  {getFieldDecorator('creationId', {
                  	initialValue: tryinit('creation'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('creation')}
                    targetType={"creation"} 
                    requestFunction={RetailStoreService.requestCandidateCreation}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.investmentInvitation} {...formItemLayout}>
                  {getFieldDecorator('investmentInvitationId', {
                  	initialValue: tryinit('investmentInvitation'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('investmentInvitation')}
                    targetType={"investmentInvitation"} 
                    requestFunction={RetailStoreService.requestCandidateInvestmentInvitation}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.franchising} {...formItemLayout}>
                  {getFieldDecorator('franchisingId', {
                  	initialValue: tryinit('franchising'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('franchising')}
                    targetType={"franchising"} 
                    requestFunction={RetailStoreService.requestCandidateFranchising}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.decoration} {...formItemLayout}>
                  {getFieldDecorator('decorationId', {
                  	initialValue: tryinit('decoration'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('decoration')}
                    targetType={"decoration"} 
                    requestFunction={RetailStoreService.requestCandidateDecoration}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.opening} {...formItemLayout}>
                  {getFieldDecorator('openingId', {
                  	initialValue: tryinit('opening'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('opening')}
                    targetType={"opening"} 
                    requestFunction={RetailStoreService.requestCandidateOpening}/>
  
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.closing} {...formItemLayout}>
                  {getFieldDecorator('closingId', {
                  	initialValue: tryinit('closing'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                <SelectObject 
                    disabled={!availableForEdit('closing')}
                    targetType={"closing"} 
                    requestFunction={RetailStoreService.requestCandidateClosing}/>
  
                  )}
                </Form.Item>
              </Col>

            </Row>
         
       

			</Form>
			
			
			
			
        </Card>
        
	<ConsumerOrderModalTable data={data.consumerOrderList} owner={owner} />
	<RetailStoreOrderModalTable data={data.retailStoreOrderList} owner={owner} />
	<GoodsModalTable data={data.goodsList} owner={owner} />
	<TransportTaskModalTable data={data.transportTaskList} owner={owner} />
	<AccountSetModalTable data={data.accountSetList} owner={owner} />
        
        
        
      </Modal>)
    
  }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
}))(Form.create()(RetailStoreAssociateForm))




